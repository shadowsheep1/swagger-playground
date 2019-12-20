package it.shadowsheep.swagger.playground.foo;

import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Schema;

//@ExtensionProperty(name = "enum-varnames", value = "ciaone", parseValue = true)
@Schema(extensions = @Extension(
        properties = {
                @ExtensionProperty(
                        name = "enum-varnames",
                        value = "[\"FOO\",\"BAR\",\"PUB\", \"BEER\"]",
                        parseValue = true)}))
public enum FooBar {
    WINNIE_THE_POO(0),
    TEDDY_BEAR(1),
    MASHA(2),
    BEAR(3);

    private final int type;

    private FooBar(final int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}