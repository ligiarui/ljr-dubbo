package cn.ligiarui.lambda;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);

    default String getDescription(){
        return "this is a converter class";
    }
}
