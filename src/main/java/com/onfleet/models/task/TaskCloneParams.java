package com.onfleet.models.task;

public class TaskCloneParams {
	private Boolean includeBarcodes;
	private Boolean includeDependencies;
	private Boolean includeMetadata;
	private TaskCloneOverridesParam overrides;

	public Boolean getIncludeBarcodes() {
		return includeBarcodes;
	}

	public void setIncludeBarcodes(Boolean includeBarcodes) {
		this.includeBarcodes = includeBarcodes;
	}

	public Boolean getIncludeDependencies() {
		return includeDependencies;
	}

	public void setIncludeDependencies(Boolean includeDependencies) {
		this.includeDependencies = includeDependencies;
	}

	public Boolean getIncludeMetadata() {
		return includeMetadata;
	}

	public void setIncludeMetadata(Boolean includeMetadata) {
		this.includeMetadata = includeMetadata;
	}

	public TaskCloneOverridesParam getOverrides() {
		return overrides;
	}

	public void setOverrides(TaskCloneOverridesParam overrides) {
		this.overrides = overrides;
	}
}
