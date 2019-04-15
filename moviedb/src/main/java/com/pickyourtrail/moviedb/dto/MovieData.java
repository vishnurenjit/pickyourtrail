package com.pickyourtrail.moviedb.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Poster", "Title", "Type", "Year", "imdbID" })
public class MovieData {

	@JsonProperty("Poster")
	private String poster;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Year")
	private Integer year;
	@JsonProperty("imdbID")
	private String imdbID;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("Poster")
	public String getPoster() {
		return poster;
	}

	@JsonProperty("Poster")
	public void setPoster(String poster) {
		this.poster = poster;
	}

	@JsonProperty("Title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("Title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("Type")
	public String getType() {
		return type;
	}

	@JsonProperty("Type")
	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("Year")
	public Integer getYear() {
		return year;
	}

	@JsonProperty("Year")
	public void setYear(Integer year) {
		this.year = year;
	}

	@JsonProperty("imdbID")
	public String getImdbID() {
		return imdbID;
	}

	@JsonProperty("imdbID")
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}