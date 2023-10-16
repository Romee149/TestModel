package com.qa.ecs.enums;

/**
 * This Enum used to provide Easily Accessed UserDefined Enum for ECS Application Entity
 *
 * @author Nahian Omar Faruqe
 * @version 1.0
 * @since 2023-07-07
 */

public enum TinType {
    SSN("0"),
	EIN("1"),
	ITIN("2"),
	SIN("3"),
	OTHER("254"),
	NA("255");

    public final String value;

    private TinType(String tinType) {
        this.value = tinType;
    }
}