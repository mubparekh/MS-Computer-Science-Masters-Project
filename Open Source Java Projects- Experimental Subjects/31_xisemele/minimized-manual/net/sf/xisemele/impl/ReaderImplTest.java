package net.sf.xisemele.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import net.sf.xisemele.api.Element;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Casos de teste para a classe {@link ReaderImpl}.
 * 
 * @author Carlos Eduardo Coral.
 */
public class ReaderImplTest {

   /**
    * Testa o método {@link ReaderImpl#version()}.
    */
   @Test
   public void testVersion() {
      Document document = createStrictMock(Document.class);
      expect(document.getXmlVersion()).andReturn("version");
      replay(document);
      
      ReaderImpl reader = new ReaderImpl(createNiceMock(Factory.class), document);
      
      assertEquals("version", reader.version());
      
      verify(document);
   }
   
   /**
    * Testa o método {@link ReaderImpl#encoding()}.
    */
   @Test
   public void testEncoding() {
      Document document = createStrictMock(Document.class);
      expect(document.getXmlEncoding()).andReturn("encoding");
      replay(document);
      
      ReaderImpl reader = new ReaderImpl(createNiceMock(Factory.class), document);
      
      assertEquals("encoding", reader.encoding());
      
      verify(document);
   }
}
