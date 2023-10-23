package com.onfleet.models.task;

public class TaskCompletionRequirementsParam {
	private Integer minimumAge;
	private Boolean notes;
	private Boolean photo;
	private Boolean signature;

	private TaskCompletionRequirementsParam(Builder builder) {
		minimumAge = builder.minimumAge;
		notes = builder.notes;
		photo = builder.photo;
		signature = builder.signature;
	}

	public Integer getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(Integer minimumAge) {
		this.minimumAge = minimumAge;
	}

	public Boolean getNotes() {
		return notes;
	}

	public void setNotes(Boolean notes) {
		this.notes = notes;
	}

	public Boolean getPhoto() {
		return photo;
	}

	public void setPhoto(Boolean photo) {
		this.photo = photo;
	}

	public Boolean getSignature() {
		return signature;
	}

	public void setSignature(Boolean signature) {
		this.signature = signature;
	}

	public static class Builder {
		private Integer minimumAge;
		private Boolean notes;
		private Boolean photo;
		private Boolean signature;

		public Builder setMinimumAge(Integer minimumAge) {
			this.minimumAge = minimumAge;
			return this;
		}

		public Builder setNotes(Boolean notes) {
			this.notes = notes;
			return this;
		}

		public Builder setPhoto(Boolean photo) {
			this.photo = photo;
			return this;
		}

		public Builder setSignature(Boolean signature) {
			this.signature = signature;
			return this;
		}

		public TaskCompletionRequirementsParam build() {
			return new TaskCompletionRequirementsParam(this);
		}
	}

}
