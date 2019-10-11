package utils;

import java.util.ResourceBundle;

public class ResourcesUtils {

    public static final String BASE_URI_PROPERTY = "baseURI";
    public static final String BASE_PATH_PROPERTY = "basePath";

    /**
     * Returns the property name for using in resource bundle
     * @param property - base property name (example: 'baseURI' or basePath)
     * @param prefix - prefix for property name (example: for property users_basePath, 'users_' is prefix)
     * @return special propertyName which you can get from Resource Bundle,
     *                 example getPropertyNameWithPrefix(BASE_PATH_PROPERTY, 'users_')
     *                 will return 'users_basePAth'
     */
    public static String getPropertyNameWithPrefix(String property, String prefix) {
        return String.join("_", prefix,property);
    }

    /**
     * Returns the property name for using in resource bundle
     * @param property - base property name (example: 'baseURI' or basePath)
     * @param postfix - postfix for property name (example: for property basePath_users, '_users' is postfix)
     * @return special propertyName which you can get from Resource Bundle,
     *                 example getPropertyNameWithPostfix(BASE_PATH_PROPERTY, '_users')
     *                 will return 'basePath_users'
     */
    public static String getPropertyNameWithPostfix(String property, String postfix) {
        return String.join("_", property, postfix);
    }

    public static String getPropertyValue(String resourceBundleName, String property) {
        return ResourceBundle.getBundle(resourceBundleName).getString(property);
    }
}
