import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.response.Response;

import java.util.List;

/**
 * Created by Waru on 3/27/2017.
 */
public class Test {
    public static void main(String[] args) {
        final PastebinFactory factory = new PastebinFactory();
        final Pastebin pastebin = factory.createPastebin("f758b7e1e061b6e7416f98176d6dc1f2");
        Response<List<Paste>> pasteResponse = pastebin.getTrendingPastes();
        if (pasteResponse.hasError()) {
            System.out.println("Unable to read trendings!");
            return;
        }
        final List<Paste> pastes = pasteResponse.get();
        for(Paste paste : pastes) {
            final Response<String> pasteResponse1 = pastebin.getRawPaste(paste.getKey());
            if (pasteResponse1.hasError()) {
                System.out.println("Unable to read paste content!");
                return;
            }
            System.out.println("Paste title: " + paste.getTitle());
            System.out.println("Paste key: " +paste.getKey());
            System.out.println(pasteResponse.get());
//            m1(paste.getKey());

        }

    }

    public static void m1(String k){
        final PastebinFactory factory = new PastebinFactory();
        final Pastebin pastebin = factory.createPastebin("f758b7e1e061b6e7416f98176d6dc1f2");
        final String pasteKey = k;
        final Response<String> pasteResponse = pastebin.getRawPaste(pasteKey);
        if (pasteResponse.hasError()) {
            System.out.println("Unable to read paste content!");
            return;
        }
        System.out.println(pasteResponse.get());
    }
}
