package service;


import api.services.PriceToTextService;


public class PriceToTextStub implements PriceToTextService {


    public String getFinalPriceConversion() {
        return "Hello printStream!";
    }

    @Override
    public void categoryConstruction(short[] array, short idForText, StringBuilder result) {

    }

    @Override
    public void numberConstruction(short n, short idForText, StringBuilder result) {

    }

    @Override
    public void dozensConstruction(short n, short d, StringBuilder result) {

    }

    @Override
    public void hundredsConstruction(short h, StringBuilder result) {

    }

    @Override
    public void assignCategory(short d, short n, short idForText, StringBuilder result) {

    }
}
