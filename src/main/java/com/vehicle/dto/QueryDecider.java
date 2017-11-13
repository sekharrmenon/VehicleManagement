package com.vehicle.dto;

import org.elasticsearch.index.query.MatchQueryBuilder.Operator;

public class QueryDecider {
	
	private String searchParam;
	private Boolean whitespace;
	private Boolean specialChar;
	private Operator operator;
	
	public String getSearchParam() {
		return searchParam;
	}
	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}
	public Boolean getWhitespace() {
		return whitespace;
	}
	public void setWhitespace(Boolean whitespace) {
		this.whitespace = whitespace;
	}
	public Boolean getSpecialChar() {
		return specialChar;
	}
	public void setSpecialChar(Boolean specialChar) {
		this.specialChar = specialChar;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	

}
