package dao;

import java.io.IOException;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class Dao2Generator {

    public static void main(String[] args) throws IOException, Exception {

        Schema schema = new Schema(3, "com.foobnix.dao2");

        Entity note = schema.addEntity("FileMeta");

        note.addStringProperty("path").primaryKey().indexAsc("path_asc", true).indexDesc("path_desc", true);
        note.addStringProperty("title").indexAsc("title_asc", false).indexDesc("title_desc", false);
        note.addStringProperty("author").indexAsc("author_asc", false).indexDesc("author_desc", false);
        note.addStringProperty("sequence");
        note.addStringProperty("genre");
        note.addStringProperty("child");
        note.addStringProperty("annotation");
        note.addIntProperty("sIndex");

        note.addIntProperty("cusType");

        note.addStringProperty("ext");
        note.addLongProperty("size").indexAsc("size_asc", false).indexDesc("size_desc", false);
        note.addLongProperty("date").indexAsc("date_asc", false).indexDesc("date_desc", false);

        note.addStringProperty("dateTxt");
        note.addStringProperty("sizeTxt");
        note.addStringProperty("pathTxt").indexAsc("pathTxt_asc", false).indexDesc("pathTxt_desc", false);

        note.addBooleanProperty("isStar");
        note.addLongProperty("isStarTime");

        note.addBooleanProperty("isRecent");
        note.addLongProperty("isRecentTime");
        note.addFloatProperty("isRecentProgress");
        note.addBooleanProperty("isSearchBook");
        note.addStringProperty("lang");



        new DaoGenerator().generateAll(schema, "/home/ivan-dev/git/LirbiReader/EBookDroid/src");
    }

}

