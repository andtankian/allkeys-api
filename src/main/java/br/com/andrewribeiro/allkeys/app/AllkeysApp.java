package br.com.andrewribeiro.allkeys.app;


import br.com.andrewribeiro.allkeys.utils.Constants;
import br.com.andrewribeiro.ribrest.Ribrest;

/**
 *
 * @author Andrew Ribeiro
 */
public class AllkeysApp {

    public static void main(String[] args) {
        Ribrest.getInstance()
                .appBaseUrl(Constants.BASE_URL)
                .appName(Constants.APP_NAME)
                .persistenceUnitName(Constants.APP_NAME)
                .staticPath(Constants.STATIC_PATH)
                .staticSrc(Constants.STATIC_SRC)
                .init();
    }

}
