package com.remigiusset.magazine.bootstrap;

import com.remigiusset.magazine.domain.Desktop;
import com.remigiusset.magazine.domain.Notebook;
import com.remigiusset.magazine.domain.RuggedNotebook;
import com.remigiusset.magazine.domain.Tablet;
import com.remigiusset.magazine.repositories.DesktopRepository;
import com.remigiusset.magazine.repositories.NotebookRepository;
import com.remigiusset.magazine.repositories.RuggedNotebookRepository;
import com.remigiusset.magazine.repositories.TabletRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataLoader implements CommandLineRunner {

    DesktopRepository desktopRepository;
    NotebookRepository notebookRepository;
    TabletRepository tabletRepository;
    RuggedNotebookRepository ruggedNotebookRepository;

    public DBDataLoader(DesktopRepository desktopRepository, NotebookRepository notebookRepository, TabletRepository tabletRepository, RuggedNotebookRepository ruggedNotebookRepository) {
        this.desktopRepository = desktopRepository;
        this.notebookRepository = notebookRepository;
        this.tabletRepository = tabletRepository;
        this.ruggedNotebookRepository = ruggedNotebookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //desktop

        Desktop fujitsu = new Desktop();
        fujitsu.setName("Fujitsu");
        fujitsu.setStatus("available");
        fujitsu.setPreorder("yes");
        fujitsu.setCondition("new");

        Desktop dell = new Desktop();
        dell.setName("Dell");
        dell.setStatus("available");
        dell.setPreorder("yes");
        dell.setCondition("new");

        Desktop hp = new Desktop();
        hp.setName("HP");
        hp.setStatus("unavailable");
        hp.setPreorder("no");
        hp.setCondition("new");

        Desktop lenovo = new Desktop();
        lenovo.setName("Lenovo");
        lenovo.setStatus("available");
        lenovo.setPreorder("yes");
        lenovo.setCondition("new");

        desktopRepository.save(fujitsu);
        desktopRepository.save(dell);
        desktopRepository.save(hp);
        desktopRepository.save(lenovo);


        System.out.println("Success !");

        //Notebook

        Notebook apple = new Notebook();
        apple.setName("Apple");
        apple.setStatus("unavailable");
        apple .setPreorder("yes");
        apple .setRanking("good");

        Notebook acer = new Notebook();
        acer.setName("acer");
        acer.setStatus("available");
        acer.setPreorder("yes");
        acer.setRanking("good");

        Notebook asus = new Notebook();
        asus.setName("Asus");
        asus.setStatus("available");
        asus.setPreorder("ask");
        asus.setRanking("low");

        Notebook thinkpad = new Notebook();
        thinkpad.setName("Thinkpad");
        thinkpad.setStatus("available");
        thinkpad.setPreorder("noway");
        thinkpad.setRanking("best");

        notebookRepository.save(apple);
        notebookRepository.save(acer);
        notebookRepository.save(asus);
        notebookRepository.save(thinkpad);

        System.out.println("Success 2 !!");

        //ruggednoteboook

        RuggedNotebook getac = new RuggedNotebook();
        getac.setName("Getac");
        getac.setStatus("available");
        getac.setMade("magnesium");
        getac.setWaterproof("yes");

        RuggedNotebook panasonic = new RuggedNotebook();
        panasonic.setName("Panasonic");
        panasonic.setStatus("available");
        panasonic.setMade("carbon");
        panasonic.setWaterproof("no");

        ruggedNotebookRepository.save(getac);
        ruggedNotebookRepository.save(panasonic);

        System.out.println("Success 3 !!!");

        //tablet

        Tablet samsung = new Tablet();
        samsung.setName("Samsung");
        samsung.setStatus("available");
        samsung.setColour("white");
        samsung.setSize("9'");

        Tablet huawei = new Tablet();
        huawei.setName("Huawei");
        huawei.setStatus("available");
        huawei.setColour("black");
        huawei.setSize("7'");

        tabletRepository.save(samsung);
        tabletRepository.save(huawei);



        System.out.println("Success 4 !!!!");
    }

}


