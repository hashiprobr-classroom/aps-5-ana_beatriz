package br.edu.insper.desagil.pi.freela;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private List<Tarefa> tarefas;

    public Lista(){
        tarefas = new ArrayList<>();
    }

    public List<Tarefa> getTarefas(){return tarefas;}

    public void adiciona(Tarefa tarefa){
        for (int i=0; i< tarefas.size(); i++){
            Tarefa t = tarefas.get(i);
            if (t.getID() == tarefa.getID()){
                return;
            }
        }
        tarefas.add(tarefa);
    }

}
