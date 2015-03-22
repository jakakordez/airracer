package tk.jakakordez.airracer;

import android.content.res.AssetManager;

import java.util.ArrayList;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Jaka on 17.3.2015.
 */
public class MeshCollection {
    ArrayList<Mesh> meshes;
    AssetManager cnt;
    ArrayList<String> paths;
    public MeshCollection(AssetManager content){
        cnt = content;
        meshes = new ArrayList<Mesh>();
        paths = new ArrayList<String>();
    }

    public int Import(String path){
        for(int i = 0; i < paths.size(); i++){
            if(paths.get(i) == path) return i;
        }
        meshes.add(new Mesh(path, cnt));
        return meshes.size()-1;
    }

    public void Draw(int index, GL10 gl){
        meshes.get(index).Draw(gl, 0);
    }
}
