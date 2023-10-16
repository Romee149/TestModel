package com.qa.ecs.enums;

public enum AddressType {

	 UNKNOWN("0"),
	 MAILING_ONLY_PO("1"),
	 RESIDENCE("2"),
	 PRIOR_RESIDENCE("3"),
	 WORK_OFFICE("4"),
	 VACATION("5"),
	 SHIPPING("6"),
	 BILLING("7"),
	 HEADQUARTER("8"),
	 BRANCH_STORE("9"),
	 NON_RESIDENT_PROPERTY("10"),
	 OTHER("254"),
	 NA("255");

	public final String value;

	private AddressType(String addressType) {
		this.value = addressType;
	}

}
