/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ws.b.takehome1;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author User
 */
@Controller
public class HomeController {
    
     @RequestMapping("/data")
    public String getLogin(@RequestParam(value="mskkannama") String nama,
                           @RequestParam(value="mskkantgl") String tanggal,
                           @RequestParam(value="mskkanfoto") MultipartFile foto,
                           Model model)
        
    throws IOException{
        
        byte[] img = foto.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String link = "data:image/png;base64,".concat(base64Image);
        model.addAttribute("Kirimnama", nama);
        model.addAttribute("Kirimtanggal", tanggal);
        model.addAttribute("Kirimfile", link);
        return "Hasil";
    
    
    }
}

