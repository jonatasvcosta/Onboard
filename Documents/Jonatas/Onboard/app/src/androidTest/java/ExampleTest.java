import android.test.InstrumentationTestCase;

import com.example.taqtile.onboard.User;

import java.util.HashMap;

/**
 * Created by taqtile on 1/13/16.
 */
public class ExampleTest extends InstrumentationTestCase {
    public void testUsuarioViewCount() throws Exception {
        User usuario = new User();
        //Teste resetViewCount
        for(int i = 0; i < 10; i++) usuario.resetViewCount(i);
        for(int i = 0; i < 10; i++) assertEquals(0, usuario.getViewCount(i));
        //Teste incrementViewCount
        for(int i = 0; i < 10; i++) usuario.incrementViewCount(i);
        for(int i = 0; i < 10; i++) assertEquals(1,usuario.getViewCount(i));
        //Teste list
        //1. Testa se os 10 objetos usuários são gerados
        assertEquals(10, usuario.list(0).size());
        //2. Testa se os 10 objetos estão com todos os elementos preenchidos
        HashMap <Integer, User.info>h = usuario.list(0);
        for(int i = 0; i < h.size(); i++){
            assertEquals(true,h.get(i).first_name.length() > 0);
            assertEquals(true,h.get(i).last_name.length() > 0);
            assertEquals(true,h.get(i).avatar.length() > 0);
        }
    }
}
