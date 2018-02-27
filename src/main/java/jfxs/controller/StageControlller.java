package jfxs.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.HashMap;
import org.apache.log4j.Logger;

/**
 * @类名: ${CLASS_NAME}
 * @包名: jfxs.controller
 * @描述: ${TODO}(用一句话描述该文件做什么)
 * @日期: 2018/2/27 11:35
 * @版本: V1.0
 * @创建人：马东
 * @修改人：马东
 */
public class StageControlller {
    private HashMap<String,Stage> stages = new HashMap<>();

    private static Logger logger = Logger.getLogger(StageControlller.class);
    /**
     * 添加stage舞台
     * @param key
     * @param stage
     */
    public void addStage(String key,Stage stage){
        stages.put(key,stage);
    }

    /**
     * 获取stage舞台
     * @param key
     * @return
     */
    public Stage getStageByKey(String key){
        return stages.get(key);
    }

    /**
     * 加载窗口地址，需要fxml资源文件属于独立的窗口并用Pane容器或其子类继承
     * @param key
     * @param resources
     * @param styles
     * @return
     * @throws IOException
     */
    public boolean loadStage(String key, String resources, StageStyle... styles) {
        FXMLLoader  loader = new FXMLLoader(getClass().getResource(resources));
        Pane tempPane = null;
        try {
            tempPane = (Pane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        ControllerStage controllerStage = loader.getController();
        controllerStage.setStageController(this);
        Scene tempSence = new Scene(tempPane);
        Stage tempStage = new Stage();
        tempStage.setScene(tempSence);

        for (StageStyle stageStyle: styles){
            tempStage.initStyle(stageStyle);
        }
        this.addStage(key,tempStage);
        return true;
    }

    /**
     * 显示窗口
     * @param key
     * @return
     */
    public boolean showStage(String key){
        this.getStageByKey(key).show();
        return true;
    }

    /**
     * 关闭前一个窗口，显示新窗口
     * @param show
     * @param close
     * @return
     */
    public boolean showNewStageAndHideOldStage(String show,String close){
        this.getStageByKey(close).close();
        showStage(show);
        return true;
    }

    /**
     * 在map中删除stage对象
     * @param key
     * @return
     */
    public boolean unLoadStage(String key){
        if (stages.remove(key) == null){
            System.out.println("窗口不存在，请检查名称");
            return false;
        }
        return true;
    }
}
