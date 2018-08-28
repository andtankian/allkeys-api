package br.com.andrewribeiro.allkeys.app;


import br.com.andrewribeiro.ribrest.Ribrest;

/**
 *
 * @author Andrew Ribeiro
 */
public class AllkeysApp {

    public static void main(String[] args) {
        Ribrest.getInstance()
                .appBaseUrl("http://localhost:2007/")
                .appName("allkeys")
                .persistenceUnitName("allkeys")
                .init();
    }

}
