package pl.allegro.finance.tradukisto.internal.languages.bulgarian

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static pl.allegro.finance.tradukisto.internal.Container.bulgarianContainer

class BulgarianValuesTest extends Specification {

    static intConverter = bulgarianContainer().getIntegerConverter()
    static longConverter = bulgarianContainer().getLongConverter()

    @Unroll
    def "should convert #value to '#words' in Bulgarian"() {
        expect:
        intConverter.asWords(value) == words

        where:
        value         | words
        0             | "нула"
        1             | "един"
        2             | "два"
        3             | "три"
        4             | "четири"
        5             | "пет"
        6             | "шест"
        7             | "седем"
        8             | "осем"
        9             | "девет"

        11            | "единадесет"
        12            | "дванадесет"
        13            | "тринадесет"
        14            | "четиринадесет"
        15            | "петнадесет"
        16            | "шестнадесет"
        17            | "седемнадесет"
        18            | "осемнадесет"
        19            | "деветнадесет"

        10            | "десет"
        20            | "двадесет"
        30            | "тридесет"
        40            | "четиридесет"
        50            | "петдесет"
        60            | "шестдесет"
        70            | "седемдесет"
        80            | "осемдесет"
        90            | "деветдесет"

        21            | "двадесет един"
        37            | "тридесет седем"
        43            | "четиридесет три"
        58            | "петдесет осем"
        69            | "шестдесет девет"
        76            | "седемдесет шест"
        82            | "осемдесет два"
        95            | "деветдесет пет"

        100           | "сто"
        200           | "двеста"
        300           | "триста"
        400           | "четиристотин"
        500           | "петстотин"
        600           | "шестстотин"
        700           | "седемстотин"
        800           | "осемстотин"
        900           | "деветстотин"

        111           | "сто единадесет"
        272           | "двеста седемдесет два"
        387           | "триста осемдесет седем"
        448           | "четиристотин четиридесет осем"
        569           | "петстотин шестдесет девет"
        625           | "шестстотин двадесет пет"
        782           | "седемстотин осемдесет два"
        895           | "осемстотин деветдесет пет"
        999           | "деветстотин деветдесет девет"

        1_000         | "хиляда"
        2_000         | "две хиляди"
        3_000         | "три хиляди"
        4_000         | "четири хиляди"
        5_000         | "пет хиляди"
        7_634         | "седем хиляди шестстотин тридесет четири"
        11_000        | "единадесет хиляди"
        15_000        | "петнадесет хиляди"
        21_000        | "двадесет една хиляди"
        24_190        | "двадесет четири хиляди сто деветдесет"
        653_000       | "шестстотин петдесет три хиляди"
        123_454       | "сто двадесет три хиляди четиристотин петдесет четири"
        700_000       | "седемстотин хиляди"
        999_999       | "деветстотин деветдесет девет хиляди деветстотин деветдесет девет"

        1_000_000     | "един милион"
        2_000_000     | "два милиона"
        5_000_000     | "пет милиона"
        23_437_219    | "двадесет три милиона четиристотин тридесет седем хиляди двеста деветнадесет"
        100_000_000   | "сто милиона"
        123_456_789   | "сто двадесет три милиона четиристотин петдесет шест хиляди седемстотин осемдесет девет"
        322_089_890   | "триста двадесет два милиона осемдесет девет хиляди осемстотин деветдесет"

        1_000_000_000 | "един милиард"
        2_147_483_647 | "два милиарда сто четиридесет седем милиона четиристотин осемдесет три хиляди шестстотин четиридесет седем"
    }

    @Ignore("Needs Bulgarian long converter and values for trillion, quadrillion, quintillion")
    @Unroll
    def "should convert long #value to '#words' in Bulgarian"() {
        expect:
            longConverter.asWords(value) == words

        where:
            value                     | words
            5_000_000_000             | ""

            1_000_000_000_000         | ""
            2_000_000_000_000         | ""
            5_000_000_000_000         | ""

            1_000_000_000_000_000     | ""
            2_000_000_000_000_000     | ""
            5_000_000_000_000_000     | ""

            1_000_000_000_000_000_000 | ""
            2_000_000_000_000_000_000 | ""
            Long.MAX_VALUE            | ""
    }
}
