module waterworld {
    requires hanyaeger;
    requires com.google.guice;
    requires java.desktop;

    exports com.github.hanyaeger;

    opens audio;
    opens backgrounds;
    opens sprites;
}
