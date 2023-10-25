package com.onfleet.models.task;

public class TaskCloneParams {
	private Boolean includeBarcodes;
	private Boolean includeDependencies;
	private Boolean includeMetadata;
	private TaskCloneOverridesParam overrides;

	private TaskCloneParams(Builder builder) {
		includeBarcodes = builder.includeBarcodes;
		includeDependencies = builder.includeDependencies;
		includeMetadata = builder.includeMetadata;
		overrides = builder.overrides;
	}

	public static class Builder {
		private Boolean includeBarcodes;
		private Boolean includeDependencies;
		private Boolean includeMetadata;
		private TaskCloneOverridesParam overrides;

		public Builder setIncludeBarcodes(Boolean includeBarcodes) {
			this.includeBarcodes = includeBarcodes;
			return this;
		}

		public Builder setIncludeDependencies(Boolean includeDependencies) {
			this.includeDependencies = includeDependencies;
			return this;
		}

		public Builder setIncludeMetadata(Boolean includeMetadata) {
			this.includeMetadata = includeMetadata;
			return this;
		}

		public Builder setOverrides(TaskCloneOverridesParam overrides) {
			this.overrides = overrides;
			return this;
		}

		public TaskCloneParams build() {
			return new TaskCloneParams(this);
		}
	}
}
