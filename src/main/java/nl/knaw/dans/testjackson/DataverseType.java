package nl.knaw.dans.testjackson;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DataverseType {
  UNCATEGORIZED("UNCATEGORIZED"),
  ARCHEOLOGY("ARCH EOLOGY"),
  HUMANITIES("HUMANITIES");
  private String value;

  DataverseType(String displayName) {
    this.value = displayName;
  }

  @JsonValue
  public String value() { return value; }

  // Optionally and/or additionally, toString.
  @Override public String toString() { return value; }
}

