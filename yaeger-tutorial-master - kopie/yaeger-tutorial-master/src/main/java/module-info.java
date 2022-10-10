module waterworld {
    requires hanyaeger;
    requires com.google.guice;

    exports com.github.hanyaeger;

    opens audio;
    opens backgrounds;
    opens sprites;
}
