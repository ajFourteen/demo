package explicit.code.demo04;

interface Fuel<SELF extends Fuel<?>> {
    int amount();

    SELF add(SELF fuel);
}
