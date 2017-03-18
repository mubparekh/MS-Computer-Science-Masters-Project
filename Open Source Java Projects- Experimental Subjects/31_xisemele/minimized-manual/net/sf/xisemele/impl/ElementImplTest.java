package net.sf.xisemele.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import net.sf.xisemele.api.Attribute;
import net.sf.xisemele.api.Element;
import net.sf.xisemele.api.Value;
import net.sf.xisemele.api.ValueList;
import net.sf.xisemele.exception.ChildNotFoundException;
import net.sf.xisemele.exception.ElementIndexOutOfBoundsException;
import net.sf.xisemele.exception.ElementNotFoundException;

import org.junit.Test;
import org.w3c.dom.Node;

/**
 * Casos de teste para a classe {@link ElementImpl}.
 * 
 * @author Carlos Eduardo Coral.
 */
public class ElementImplTest {

   /**
    * Testa o método {@link ElementImpl#attributes()}.
    */
   @Test
   public void testAttributes() {
      Attribute attr1 = createNiceMock(Attribute.class);
      Attribute attr2 = createNiceMock(Attribute.class);
      Attribute attr3 = createNiceMock(Attribute.class);

      List<Attribute> attrs = Arrays.asList(attr1, attr2, attr3);

      Node node = createNiceMock(Node.class);

      Node node1 = createNiceMock(Node.class);
      Node node2 = createNiceMock(Node.class);
      Node node3 = createNiceMock(Node.class);

      List<Node> nodes = Arrays.asList(node1, node2, node3);

      Operations operations = createStrictMock(Operations.class);
      expect(operations.attributes(node)).andReturn(nodes);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createAttributes(nodes)).andReturn(attrs);
      replay(factory);
      
      ElementImpl element = new ElementImpl(factory, node);

      assertEquals(attrs, element.attributes());

      verify(factory, operations);
   }

   /**
    * Testa o método {@link ElementImpl#child(int)} para a exceção {@link ElementIndexOutOfBoundsException}.
    */
   @Test(expected = ElementIndexOutOfBoundsException.class)
   public void testChildWithElementIndexOutOfBoundsException() {
      Node node = createNiceMock(Node.class);
      expect(node.getNodeName()).andReturn("name");
      replay(node);

      Operations operations = createStrictMock(Operations.class);
      expect(operations.child(node, 3)).andReturn(null);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createOperations()).andReturn(operations);
      replay(factory);
      
      ElementImpl element = new ElementImpl(factory, node);

      element.child(3);
   }

   /**
    * Testa o método {@link ElementImpl#child(String)} para a exceção {@link ElementNotFoundException}.
    */
   @Test(expected = ChildNotFoundException.class)
   public void testChildWithElementNotFoundException() {
      Node node = createStrictMock(Node.class);
      expect(node.getNodeName()).andReturn("name");
      replay(node);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.child(node, "childName")).andReturn(null);
      replay(operations);

      Factory factory = createStrictMock(Factory.class);
      expect(factory.createOperations()).andReturn(operations);
      replay(factory);
      
      ElementImpl element = new ElementImpl(factory, node);
      
      element.child("childName");
   }
   
   /**
    * Testa o método {@link ElementImpl#value()}.
    */
   @Test
   public void testValue() {
      Node node1 = createStrictMock(Node.class);
      expect(node1.getTextContent()).andReturn("value");
      replay(node1);
      
      Node node2 = createNiceMock(Node.class);
      
      Operations operations = createStrictMock(Operations.class);
      expect(operations.containsChildren(node1)).andReturn(Boolean.FALSE);
      expect(operations.containsChildren(node2)).andReturn(Boolean.TRUE);
      replay(operations);
      
      Value value1 = createNiceMock(Value.class);
      Value value2 = createNiceMock(Value.class);
      
      Factory factory = createStrictMock(Factory.class);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createValue("value")).andReturn(value1);
      expect(factory.createOperations()).andReturn(operations);
      expect(factory.createNullValue()).andReturn(value2);
      replay(factory);
      
      ElementImpl element1 = new ElementImpl(factory, node1);
      
      assertSame(value1, element1.value());
      
      ElementImpl element2 = new ElementImpl(factory, node2);
      
      assertSame(value2, element2.value());
      
      verify(node1, operations, factory);
   }
}
