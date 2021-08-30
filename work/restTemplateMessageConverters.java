/**
 * 支持 hiiot 的 application/x-zc-object 请求头
 * string -> json
 * @author lvxuechun
 * @date 2021/4/8
 */
public class XzcObjectMessageConverter extends MappingJackson2HttpMessageConverter {
    public XzcObjectMessageConverter() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.APPLICATION_JSON);
        mediaTypes.add(new MediaType("application", "x-zc-object"));
        setSupportedMediaTypes(mediaTypes);
    }
}


@Configuration
public class RestTemplateConfig {
    @PostConstruct
    public void restTemplateMqtt() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new XzcObjectMessageConverter());

        RestUtils.overrideRestTemplate(restTemplate);
    }
}
