/**
 * Provides the error stirngs as constants to the project.
 */
public class ErrorStrings {
  public static String UNKNOWN_COMMAND_ERROR = "Unknown command. No action was performed.";

  public static String INVALID_COMMAND_ERROR = "We have encountered an invalid command."
      + " Try again.\n>";

  public static String BAD_ARGUMENT_COUNT_POWER = ":pow command requires 2 agruments, "
      + "base and power.\nUSAGE> :pow x y\nexample (2^3)> :pow 2 3";

  public static String FIRST_ARGUMENT_NOT_NUM_POWER = "The first argument of :pow must be a "
      + "number.\nUSAGE> :pow x y\nexample (2^3)> :pow 2 3";

  public static String SECOND_ARGUMENT_NOT_NUM_POWER = "The second argument of :pow must be "
      + "an integer.\nUSAGE> :pow x y\nexample (2^3)> :pow 2 3";

  public static String ZERO_BASE_NEGATIVE_POWER = "Base cannot be 0 when power is negative.";
}
