package br.edu.insper.desagil.pi.freela;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TarefaTest {
    private Tarefa t;

    @BeforeEach
    void setUp(){
        t = new Tarefa(1);
    }

    private Momento momentoFalsoComMinuto(int minuto){
        Momento momento = mock(Momento.class);
        when(momento.minutos()).thenReturn(minuto);
        return momento;
    }

    @Test
    void constroi(){
        assertEquals(1,t.getID());
        assertEquals("",t.getDescricao());
        assertNull(t.getInicio());
        assertNull(t.getFim());
    }

    @Test
    void mudaDescricao(){
        t.setDescricao("Descricao");
        assertEquals("Descricao",t.getDescricao());
    }

    @Test
    void momentosValidos(){
        Momento m1 = momentoFalsoComMinuto(1);
        Momento m2 = momentoFalsoComMinuto(2);
        t.atualiza(m1,m2);
        assertEquals(m1,t.getInicio());
        assertEquals(m2,t.getFim());
    }

    @Test
    void momentosInvalidos(){
        Momento m1 = momentoFalsoComMinuto(2);
        Momento m2 = momentoFalsoComMinuto(1);
        assertThrows(IllegalArgumentException.class, () -> {t.atualiza(m1,m2);});
    }
}
