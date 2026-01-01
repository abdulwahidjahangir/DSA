package ArrayAndHashing;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class EncodeAndDecodeTinyURL {

    private final ConcurrentHashMap<String, String> shortToLong = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> longToShort = new ConcurrentHashMap<>();

    private final AtomicLong counter = new AtomicLong(1000);

    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String DOMAIN = "http://tiny.url/";

    public String encode(String longUrl) {

        // Atomic: same long URL always maps to the same short code
        String shortCode = longToShort.computeIfAbsent(longUrl, key -> {
            String code;
            do {
                code = encodeBase62(counter.incrementAndGet());
            } while (shortToLong.containsKey(code)); // defensive collision check

            shortToLong.put(code, key);
            return code;
        });

        return DOMAIN + shortCode;
    }

    public String decode(String shortUrl) {
        String shortCode = shortUrl.replace(DOMAIN, "");
        return shortToLong.getOrDefault(shortCode, "");
    }

    private String encodeBase62(long num) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(BASE62.charAt((int) (num % 62)));
            num /= 62;
        } while (num > 0);
        return sb.reverse().toString();
    }
}
