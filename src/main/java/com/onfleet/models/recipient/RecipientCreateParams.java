package com.onfleet.models.recipient;

import com.onfleet.models.Metadata;

import java.util.List;

public class RecipientCreateParams {
	private String name;
	private String notes;
	private String phone;
	private Boolean skipPhoneNumberValidation;
	private Boolean skipSmsNotifications;
	private Boolean useLongCodeForText;
	private List<Metadata> metadata;

	private RecipientCreateParams(Builder builder) {
		name = builder.name;
		phone = builder.phone;
		notes = builder.notes;
		skipPhoneNumberValidation = builder.skipPhoneNumberValidation;
		skipSmsNotifications = builder.skipSmsNotifications;
		useLongCodeForText = builder.useLongCodeForText;
		metadata = builder.metadata;
	}

	public static class Builder {
		private final String name;
		private final String phone;
		private String notes;
		private Boolean skipPhoneNumberValidation;
		private Boolean skipSmsNotifications;
		private Boolean useLongCodeForText;
		private List<Metadata> metadata;

		public Builder(String name, String phone) {
			this.name = name;
			this.phone = phone;
		}

		public Builder setNotes(String notes) {
			this.notes = notes;
			return this;
		}

		public Builder setSkipPhoneNumberValidation(Boolean skipPhoneNumberValidation) {
			this.skipPhoneNumberValidation = skipPhoneNumberValidation;
			return this;
		}

		public Builder setSkipSmsNotifications(Boolean skipSmsNotifications) {
			this.skipSmsNotifications = skipSmsNotifications;
			return this;
		}

		public Builder setUseLongCodeForText(Boolean useLongCodeForText) {
			this.useLongCodeForText = useLongCodeForText;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public RecipientCreateParams build() {
			return new RecipientCreateParams(this);
		}
	}

}
