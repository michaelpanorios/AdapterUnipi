package adapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FieldsValidation {

    String[] shopGenres = {"Action and Adventure", "Classic", "Novel", "Mystery", "Fantasy"};

    public void populateValidations(ElementsBookOrder elementsBookOrder) throws ParseException {
        /** Name validation */
        if (elementsBookOrder.getAuthor().isEmpty()) elementsBookOrder.setAuthor("ERROR: Author field is blank.");
        else elementsBookOrder.setAuthor(elementsBookOrder.getAuthor().toUpperCase());

        /** Title validation is not important */
        elementsBookOrder.setTitle(elementsBookOrder.getTitle().trim());

        /** Genre validation within shop's available genres */
        if (elementsBookOrder.getGenre().isEmpty()) elementsBookOrder.setGenre("ERROR: Genre field is blank.");
        else checkExistingGenres(elementsBookOrder, elementsBookOrder.getGenre());

        /** Price validation for accepting only currency chars */
        String regex = "(?:\\b(?:[BS]/\\.|R(?:D?\\$|p))|\\b(?:[TN]T|[CJZ])\\$|Дин\\.|\\b(?:Bs|Ft|Gs|K[Mč]|Lek|B[Zr]|k[nr]|[PQLSR]|лв|ден|RM|MT|lei|zł|USD|GBP|EUR|JPY|CHF|SEK|DKK|NOK|SGD|HKD|AUD|TWD|NZD|CNY|KRW|INR|CAD|VEF|EGP|THB|IDR|PKR|MYR|PHP|MXN|VND|CZK|HUF|PLN|TRY|ZAR|ILS|ARS|CLP|BRL|RUB|QAR|AED|COP|PEN|CNH|KWD|SAR)|\\$[Ub]|[\\p{Sc}ƒ])\\s?(?:\\d{1,3}(?:,\\d{3})*|\\d+)(?:\\.\\d{1,2})?(?!\\.?\\d)\n";
        if (elementsBookOrder.getPrice().isEmpty() || !elementsBookOrder.getPrice().matches(regex)) {
            elementsBookOrder.setPrice("ERROR: Price field is blank, it must start with currency character");
        }
        /** Date validation which generates the date */
            if (elementsBookOrder.getPublish_date().isEmpty()) {
                elementsBookOrder.setPublish_date("ERROR");
            } else {
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(elementsBookOrder.getPublish_date());
                elementsBookOrder.setPublish_date(String.valueOf("Order proceed on: " + java.util.Calendar.getInstance().getTime()));
            }
        /** Description validation is not important */
        elementsBookOrder.setDescription(elementsBookOrder.getDescription().trim());

    }

    private void checkExistingGenres(ElementsBookOrder elementsBookOrder, String orderGenre) {
        for (String shopGenre : shopGenres) {
            if(shopGenre.equals(orderGenre)) elementsBookOrder.setGenre(orderGenre.toUpperCase());
            else elementsBookOrder.setGenre("ERROR: Our shop do not provide this genre");
        }
    }
}

