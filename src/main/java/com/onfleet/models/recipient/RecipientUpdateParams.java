package com.onfleet.models.recipient;

import com.onfleet.models.Metadata;

import java.util.List;

public class RecipientUpdateParams {
	private String name;
	private String notes;
	private Boolean skipSmsNotifications;
	private List<Metadata> metadata;

	private RecipientUpdateParams(Builder builder) {
		name = builder.name;
		notes = builder.notes;
		skipSmsNotifications = builder.skipSmsNotifications;
		metadata = builder.metadata;
	}

	public static class Builder {
		private String name;
		private String notes;
		private Boolean skipSmsNotifications;
		private List<Metadata> metadata;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setNotes(String notes) {
			this.notes = notes;
			return this;
		}

		public Builder setSkipSmsNotifications(Boolean skipSmsNotifications) {
			this.skipSmsNotifications = skipSmsNotifications;
			return this;
		}

		public Builder setMetadata(List<Metadata> metadata) {
			this.metadata = metadata;
			return this;
		}

		public RecipientUpdateParams build() {
			return new RecipientUpdateParams(this);
		}
	}

}
