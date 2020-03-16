//package com.jtzyfw.utli;
//
//public class WebMvcProperties {
//    //spring Boot在这里进行了默认的静态资源过滤配置，
//    // 其中staticPathPattern，默认定义在WebMvcProperties中
//    private String staticPathPattern ="/**";
//    //this.resourceProperties.getStaticLocations ()
//    // 获取到的默认静态资源位置定义在ResourceProperties中,四个
//    private static final String[] CLASSPATH_RESOURCE_LOCATIONS ={
//    "classpath:/META-INF/resources/","classpath:/resources/",
//    "classpath:/static","classpath:/public/"};
//
//    /**
//     * 方法我可以加public试试，该方法中，对这4个静态资源位置做了扩充
//     *
//     * SERVLET_LOCATIONS的定义是一个{"/"}
//     * 宗上所，Spring boot默认会过滤所有的静态资源，资源位置有5个，按照定义，
//     * 5个静态资源位置的优先级依次降低。一般 情况下，spring项目不需要wabapp目录
//     * 因此第五个"/"可以暂时不考虑
//     * @param staticLocations
//     * @return
//     */
//    static String[] getResourceLocations(String[]  staticLocations){
//        String[] locations= new String[staticLocations.length+SERVLET_LOCATIONS.length] ;
//        System.arraycopy(staticLocations,0,locations,0,staticLocations.length) ;
//        System.arraycopy(SERVLET_LOCATIONS,0 ,locations,staticLocations.length,
//                SERVLET_LOCATIONS.length);
//        return locations;
//    }
//}
