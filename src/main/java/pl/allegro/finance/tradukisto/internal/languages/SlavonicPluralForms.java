package pl.allegro.finance.tradukisto.internal.languages;

import pl.allegro.finance.tradukisto.internal.support.Range;

public class SlavonicPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    private final GenderType genderType;

    public SlavonicPluralForms(String singularForm, String pluralForm, String genitivePluralForm) {
        this(singularForm, pluralForm, genitivePluralForm, GenderType.NON_APPLICABLE);
    }

    public SlavonicPluralForms(String singularForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;

        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        if (value == 1) {
            return singularForm;
        }
        if (usePluralForm(value)) {
            return pluralForm;
        }
        return genitivePluralForm;
    }

    private boolean usePluralForm(Integer value) {
        return Range.closed(2, 4).contains(value % 10)
                && !Range.closed(12, 14).contains(value % 100);
    }

    @Override
    public GenderType genderType() {
        return genderType;
    }
}
