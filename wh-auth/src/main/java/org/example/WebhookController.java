package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@RestController
@RequestMapping("/api/webhooks")
public class WebhookController {
	private static final String WH_SECRET = "f1c6bacb24c07a2ab904408f97c539f4f23e10a7eb30e66a37ed42f8a47ed5c2855371cfdefe5023ceafdb74ab91b328edc436700cab25c4bcfcffd04086fe46";

	@PostMapping("/worker-duty")
	public ResponseEntity<String> validateWebhook(@RequestBody String requestBody, @RequestHeader("X-Onfleet-Signature") String signature) {
		if (isValidSignature(requestBody, signature)) {
			System.out.println("Received and validated webhook payload: " + requestBody);
			return ResponseEntity.ok("Webhook signature is valid.");
		} else {
			System.out.println("Invalid webhook signature. Discarding the request.");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Webhook signature is not valid.");
		}
	}

	private boolean isValidSignature(String body, String receivedSignature) {
		try {
			byte[] secretBytes = hexStringToByteArray(WH_SECRET);
			Mac hmacSha512 = Mac.getInstance("HmacSHA512");
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretBytes, "HmacSHA512");
			hmacSha512.init(secretKeySpec);
			byte[] hash = hmacSha512.doFinal(body.getBytes());
			byte[] receivedBytes = hexStringToByteArray(receivedSignature);
			return Arrays.equals(hash, receivedBytes);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			e.printStackTrace();
			return false;
		}
	}

	private byte[] hexStringToByteArray(String hex) {
		int len = hex.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
					+ Character.digit(hex.charAt(i + 1), 16));
		}
		return data;
	}
}
