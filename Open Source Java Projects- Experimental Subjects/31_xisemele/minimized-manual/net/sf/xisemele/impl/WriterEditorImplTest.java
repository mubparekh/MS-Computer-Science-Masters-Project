package net.sf.xisemele.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Date;

import net.sf.xisemele.api.Formatter;
import net.sf.xisemele.api.Result;
import net.sf.xisemele.exception.AttributeNotPermittedException;
import net.sf.xisemele.exception.NotWithinContextException;
import net.sf.xisemele.exception.RemoveRootNotPermittedException;
import net.sf.xisemele.exception.RootDuplicateException;
import net.sf.xisemele.exception.ValueNotPermittedException;
import net.sf.xisemele.exception.WithinContextDuplicateException;
import net.sf.xisemele.exception.WithinContextNotPermittedException;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Casos de testes para a classe {@link WriterEditorImpl}.
 * 
 * @author Carlos Eduardo Coral.
 */
public class WriterEditorImplTest {

   /**
    * Testa se dispara a exceção {@link WithinContextDuplicateException} ao chamar o método {@link WriterEditorImpl#within()}.
    */
   @Test(expected = WithinContextDuplicateException.class)
   public void testWithinWithWithinContextDuplicateException() {
      Element element = createNiceMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.TRUE);
      replay(withinContext);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(null);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.within();
   }
 
   /**
    * Testa se dispara a exceção {@link WithinContextNotPermittedException} ao chamar o método {@link WriterEditorImpl#within()}.
    */
   @Test(expected = WithinContextNotPermittedException.class)
   public void testWithinWithWithinContextNotPermittedException() {
      Element element = createStrictMock(Element.class);
      expect(element.getNodeName()).andReturn("nodeName");
      replay(element);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.FALSE);
      replay(withinContext);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.containsValue(element)).andReturn(Boolean.TRUE);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.within();
   }
 
   /**
    * Testa o método {@link WriterEditorImpl#endWithin()}.
    */
   @Test
   public void testEndWithin() {
      Element element = createNiceMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.TRUE);
      withinContext.stop();
      replay(withinContext);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(null);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.endWithin();
      
      verify(document, withinContext, factory);
   }
   
   /**
    * Testa se dispara a exceção {@link NotWithinContextException} ao chamar o método {@link WriterEditorImpl#endWithin()}.
    */
   @Test(expected = NotWithinContextException.class)
   public void testEndWithinWithNotWithinContextException() {
      Element element = createNiceMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.FALSE);
      replay(withinContext);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.TRUE);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.endWithin();
   }
   
   /**
    * Testa o método {@link WriterEditorImpl#endWithin()} para o caso em que o elemento pai do element corrente passa ser o
    * elemento corrente.
    */
   @Test
   public void testEndWithinForParent() {
      Element parent = createNiceMock(Element.class);
      
      Element element = createStrictMock(Element.class);
      expect(element.getParentNode()).andReturn(parent);
      replay(element);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.FALSE);
      replay(withinContext);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.FALSE);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.endWithin();
      assertSame(parent, writerEditor.getCurrent());
      
      verify(element, document, withinContext, operations, factory);
   }
   
   /**
    * Testa o método {@link WriterEditorImpl#element(String)}.
    */
   @Test
   public void testElement() {
      Element newElement = createNiceMock(Element.class);
      
      Element parent = createStrictMock(Element.class);
      expect(parent.appendChild(newElement)).andReturn(null);
      replay(parent);
      
      Element element = createStrictMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      expect(document.createElement("newElement")).andReturn(newElement);
      replay(document);
      
      expect(element.getOwnerDocument()).andReturn(document);
      expect(element.getParentNode()).andReturn(parent);
      replay(element);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.FALSE);
      replay(withinContext);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.FALSE);
      replay(operations);

      Validations validations = createStrictMock(Validations.class);
      validations.assertValidName("newElement");
      replay(validations);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(validations);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.element("newElement");
      assertSame(newElement, writerEditor.getCurrent());
      
      verify(parent, element, document, withinContext, operations, validations, factory);
   }
   
   /**
    * Testa o método {@link WriterEditorImpl#element(String)} no caso em que o contexto <i>within</i> está habilitado.
    */
   @Test
   public void testElementWithWithinContextEnabled() {
      Element newElement = createNiceMock(Element.class);
      
      Element element = createStrictMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      expect(document.createElement("newElement")).andReturn(newElement);
      replay(document);
      
      expect(element.getOwnerDocument()).andReturn(document);
      expect(element.appendChild(newElement)).andReturn(null);
      replay(element);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.TRUE);
      withinContext.stop();
      replay(withinContext);

      Validations validations = createStrictMock(Validations.class);
      validations.assertValidName("newElement");
      replay(validations);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(null);
      expect(factory.createValidations()).andReturn(validations);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.element("newElement");
      assertSame(newElement, writerEditor.getCurrent());
      
      verify(element, document, withinContext, validations, factory);
   }
   
   /**
    * Testa se dispara a exceção {@link RootDuplicateException} ao chamar o método {@link WriterEditorImpl#element(String)}.
    */
   @Test(expected = RootDuplicateException.class)
   public void testElementWithRootDuplicateException() {
      Element newElement = createStrictMock(Element.class);
      expect(newElement.getNodeName()).andReturn("newElement");
      replay(newElement);
      
      Element element = createStrictMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      expect(document.createElement("newElement")).andReturn(newElement);
      replay(document);
      
      expect(element.getOwnerDocument()).andReturn(document);
      expect(element.getNodeName()).andReturn("element");
      replay(element);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.FALSE);
      replay(withinContext);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.TRUE);
      replay(operations);

      Validations validations = createStrictMock(Validations.class);
      validations.assertValidName("newElement");
      replay(validations);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(validations);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.element("newElement");
   }
   
   /**
    * Testa o método {@link WriterEditorImpl#node(org.w3c.dom.Node)}.
    */
   @Test
   public void testNode() {
      Element newElement = createNiceMock(Element.class);
      
      Element parent = createStrictMock(Element.class);
      expect(parent.appendChild(newElement)).andReturn(null);
      replay(parent);
      
      Element element = createStrictMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      expect(document.importNode(newElement, true)).andReturn(newElement);
      replay(document);
      
      expect(element.getOwnerDocument()).andReturn(document);
      expect(element.getParentNode()).andReturn(parent);
      replay(element);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.FALSE);
      replay(withinContext);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.FALSE);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.node(newElement);
      assertSame(newElement, writerEditor.getCurrent());
      
      verify(parent, element, document, withinContext, operations, factory);
   }
   
   /**
    * Testa o método {@link WriterEditorImpl#node(org.w3c.dom.Node)} no caso em que o contexto <i>within</i> está habilitado.
    */
   @Test
   public void testNodeWithWithinContextEnabled() {
      Element newElement = createNiceMock(Element.class);
      
      Element element = createStrictMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      expect(document.importNode(newElement, true)).andReturn(newElement);
      replay(document);
      
      expect(element.getOwnerDocument()).andReturn(document);
      expect(element.appendChild(newElement)).andReturn(null);
      replay(element);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.TRUE);
      withinContext.stop();
      replay(withinContext);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(null);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.node(newElement);
      assertSame(newElement, writerEditor.getCurrent());
      
      verify(element, document, withinContext, factory);
   }
   
   /**
    * Testa se dispara a exceção {@link RootDuplicateException} ao chamar o método {@link WriterEditorImpl#node(org.w3c.dom.Node)}.
    */
   @Test(expected = RootDuplicateException.class)
   public void testNodeWithRootDuplicateException() {
      Element newElement = createStrictMock(Element.class);
      expect(newElement.getNodeName()).andReturn("newElement");
      replay(newElement);
      
      Element element = createStrictMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      expect(document.importNode(newElement, true)).andReturn(newElement);
      expect(document.createElement("newElement")).andReturn(newElement);
      replay(document);
      
      expect(element.getOwnerDocument()).andReturn(document);
      expect(element.getNodeName()).andReturn("element");
      replay(element);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.FALSE);
      replay(withinContext);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.TRUE);
      replay(operations);

      Validations validations = createStrictMock(Validations.class);
      validations.assertValidName("newElement");
      replay(validations);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(validations);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.node(newElement);
   }  
   
   /**
    * Testa se dispara a exceção {@link ValueNotPermittedException} ao chamar o método {@link WriterEditorImpl#value(Object)} para
    * um contexto <i>within</i> iniciado.
    */
   @Test(expected = ValueNotPermittedException.class)
   public void testValueWithValueNotPermittedExceptionCase2() {
      Element element = createStrictMock(Element.class);
      expect(element.getNodeName()).andReturn("element");
      replay(element);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);

      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.TRUE);
      replay(withinContext);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(createNiceMock(Operations.class));
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.value("value");
   }
   
   /**
    * Testa se dispara a exceção {@link ValueNotPermittedException} ao chamar o método {@link WriterEditorImpl#value(Date, String)}.
    */
   @Test(expected = ValueNotPermittedException.class)
   public void testValueForDateWithValueNotPermittedException() {
      Element element = createStrictMock(Element.class);
      expect(element.getNodeName()).andReturn("element");
      replay(element);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.containsChildren(element)).andReturn(Boolean.TRUE);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(null);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.value(new Date(), "pattern");
   }
   
   /**
    * Testa se dispara a exceção {@link AttributeNotPermittedException} ao chamar o método 
    * {@link WriterEditorImpl#attribute(String, Object)};
    */
   @Test(expected = AttributeNotPermittedException.class)
   public void testAttributeWithAttributeNotPermittedException() {
      Element element = createNiceMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.TRUE);
      replay(withinContext);

      Validations validations = createStrictMock(Validations.class);
      validations.assertValidName("attribute");
      replay(validations);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(null);
      expect(factory.createValidations()).andReturn(validations);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.attribute("attribute", "value");
   }
   
   /**
    * Testa se dispara a exceção {@link AttributeNotPermittedException} ao chamar o método 
    * {@link WriterEditorImpl#attribute(String, Date, String)}.
    */
   @Test(expected = AttributeNotPermittedException.class)
   public void testeAttributeForDateWithAttributeNotPermittedException() {
      Element element = createNiceMock(Element.class);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      WithinContext withinContext = createStrictMock(WithinContext.class);
      expect(withinContext.enabled()).andReturn(Boolean.TRUE);
      replay(withinContext);

      Validations validations = createStrictMock(Validations.class);
      validations.assertValidName("attribute");
      replay(validations);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(withinContext);
      expect(factory.createOperations()).andReturn(null);
      expect(factory.createValidations()).andReturn(validations);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.attribute("attribute", new Date(), "pattern");
   }
   
   /**
    * Testa o método {@link WriterEditorImpl#remove()}.
    */
   @Test
   public void testRemove() {
      Element parent = createStrictMock(Element.class);
      
      Element element = createStrictMock(Element.class);
      expect(element.getParentNode()).andReturn(parent);
      replay(element);
      
      expect(parent.removeChild(element)).andReturn(null);
      replay(parent);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.FALSE);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(null);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.remove();
      assertSame(parent, writerEditor.getCurrent());
    
      verify(parent, element, document, operations, factory);
   }
   
   /**
    * Testa se dispara a exceção {@link RemoveRootNotPermittedException} ao chamar o método {@link WriterEditorImpl#remove()}.
    */
   @Test(expected = RemoveRootNotPermittedException.class)
   public void testRemoveWithRemoveRootNotPermittedException() {
      Element element = createStrictMock(Element.class);
      expect(element.getNodeName()).andReturn("element");
      replay(element);
      
      Document document = createStrictMock(Document.class);
      expect(document.getDocumentElement()).andReturn(element);
      replay(document);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.isRootElement(element)).andReturn(Boolean.TRUE);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createWithinContext()).andReturn(null);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValidations()).andReturn(null);
      expect(factory.createResult(document)).andReturn(null);
      replay(factory);

      WriterEditorImpl writerEditor = new WriterEditorImpl(factory, null, document);
      writerEditor.remove();
   }
}
