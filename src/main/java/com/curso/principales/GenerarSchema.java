package com.curso.principales;

import jakarta.persistence.Persistence;

public class GenerarSchema {
	public static void main(String[] args) {
		Persistence.generateSchema("empresa", null);
	}
}
