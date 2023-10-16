package com.qa.ecs.enums;

/**
 * This Enum used to provide Easily Accessed UserDefined Enum for ECS Application Entity
 *
 * @author Nahian Omar Faruqe
 * @version 1.0
 * @since 2023-06-20
 */

public enum ECSEntity {
    ORGANIZATION("Organization"),
	CONSUMER("Consumer");

    public final String value;

    private ECSEntity(String entityName) {
        this.value = entityName;
    }
}