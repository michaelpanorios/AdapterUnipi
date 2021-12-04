package adapter;

public class FieldsValidation {

    private void populateValidations(ElementsBookOrder elementsBookOrder){
        /** Name validation */
        if(elementsBookOrder.getAuthor().isEmpty()) {
            elementsBookOrder.setAuthor("ERROR");
        } else {
            elementsBookOrder.setAuthor(elementsBookOrder.getAuthor().toUpperCase());
        }
        /** Title validation is not important */

        /** Genre validation within shop's available genres */

        /** Price validation for accepting only currency chars */

        /** Date validation which generates the date */

        /** Description validation is not important */

    }

}
