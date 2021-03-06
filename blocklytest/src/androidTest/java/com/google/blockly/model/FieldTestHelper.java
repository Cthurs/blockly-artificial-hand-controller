package com.google.blockly.model;

import org.junit.Assert;

/**
 * Helper methods for testing fields.
 */
public class FieldTestHelper {
    /**
     * Tests {@link Field.Observer} event on an {@link Field} object, including single call per
     * change per observer, multiple observers.
     *
     * @param field The field to test.
     * @param newValue The value to assign, using the serialized format of the value.
     * @param expectedOldValue The expected {@code oldValue}, in serialized form.
     * @param expectedNewValue The expected {@code newValue}, in serialized form.
     */
    public static void testObserverEvent(final Field field,
                                         final String newValue,
                                         final String expectedOldValue,
                                         final String expectedNewValue) {
        final int[] observerOneCount = {0};
        final int[] observerTwoCount = {0};

        field.registerObserver(new Field.Observer() {
            @Override
            public void onValueChanged(Field eventField, String oldValue, String newValue) {
                observerOneCount[0]++;
                Assert.assertSame(field, eventField);
                Assert.assertEquals(expectedOldValue, oldValue);
                Assert.assertEquals(expectedNewValue, newValue);

            }
        });
        field.registerObserver(new Field.Observer() {
            @Override
            public void onValueChanged(Field field, String oldValue, String newValue) {
                observerTwoCount[0]++;
            }
        });

        field.setFromString(newValue);
        Assert.assertEquals("Exactly one observation per Observer", 1, observerOneCount[0]);
        Assert.assertEquals("Exactly one observation per Observer", 1, observerTwoCount[0]);
    }

    /**
     * Tests updating a {@link Field} with a value that is expected to be the same, and thus
     * should not invoke an {@link Field.Observer} call.
     *
     * @param field The field to test.
     * @param writeValue The value to write, in serialized form.
     */
    public static void testObserverNoEvent(final Field field, final String writeValue) {
        field.registerObserver(new Field.Observer() {
            @Override
            public void onValueChanged(Field eventField, String oldValue, String newValue) {
                Assert.fail("Observer should not be call if value does not change.\n"
                        + "writeValue = " + (writeValue == null ? "null" : "\"" + writeValue + "\"")
                        + "\noldValue = " + (oldValue == null ? "null" : "\"" + oldValue + "\"")
                        + "\nnewValue = " + (newValue == null ? "null" : "\"" + newValue + "\""));
            }
        });
        field.setFromString(writeValue);
    }

    /**
     * Tests updating a {@link Field} with its existing value, and thus should not invoke an
     * {@link Field.Observer} call.
     *
     * @param field The field to test.
     */
    public static void testObserverNoEvent(final Field field) {
        testObserverNoEvent(field, field.getSerializedValue());
    }
}
