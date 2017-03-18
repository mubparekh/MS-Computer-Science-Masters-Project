package net.sf.xisemele.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Date;

import net.sf.xisemele.api.Element;
import net.sf.xisemele.api.Result;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Casos de teste para a classe {@link EditorImpl}.
 * 
 * @author Carlos Eduardo Coral.
 */
public class EditorImplTest {

   /**
    * Testa os métodos {@link EditorImpl#element(String)}, {@link EditorImpl#element(String, Object)},
    * {@link EditorImpl#element(String, Date, String)} e {@link EditorImpl#element(Element)}.
    */
   @Test
   public void testElements() {
      Object value = new Object();
      Date date = new Date();
      
      Node node = createNiceMock(Node.class);
      
      Element element = createNiceMock(Element.class);
      expect(element.node()).andReturn(node);
      replay(element);
      
      WriterEditor writerEditor = createStrictMock(WriterEditor.class);
      writerEditor.element("elementA");
      writerEditor.element("elementB");
      writerEditor.value(value);
      writerEditor.element("elementC");
      writerEditor.value(date, "pattern");
      writerEditor.node(node);
      replay(writerEditor);
      
      EditorImpl editor = new EditorImpl(writerEditor);
      assertSame(editor, editor.element("elementA"));
      assertSame(editor, editor.element("elementB", value));
      assertSame(editor, editor.element("elementC", date, "pattern"));
      assertSame(editor, editor.element(element));
      
      verify(writerEditor);
   }
   
   /**
    * Testa o método {@link EditorImpl#document()}.
    */
   @Test
   public void testDocument() {
      Document document = createNiceMock(Document.class);
      
      WriterEditor writerEditor = createStrictMock(WriterEditor.class);
      expect(writerEditor.document()).andReturn(document);
      replay(writerEditor);

      EditorImpl editor = new EditorImpl(writerEditor);
      assertSame(document, editor.document());
      
      verify(writerEditor);
   }
}
