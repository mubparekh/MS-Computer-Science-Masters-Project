package net.sf.xisemele.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import net.sf.xisemele.exception.ElementNotFoundException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Casos de teste para a classe {@link OperationsImpl}.
 * 
 * @author Carlos Eduardo Coral.
 */
public class OperationsImplTest {

   /**
    * Testa o método {@link OperationsImpl#child(Node, int)}.
    */
   @Test
   public void testChildForIndex() {
      Node child1 = createNiceMock(Node.class);
      Node child2 = createNiceMock(Node.class);
      
      Node node = createNiceMock(Node.class);
      
      OperationsHelper operationsHelper = createStrictMock(OperationsHelper.class);
      expect(operationsHelper.children(node)).andReturn(Arrays.asList(child1, child2)).times(4);
      replay(operationsHelper);
      
      OperationsImpl operations = new OperationsImpl(operationsHelper);
      assertNull(operations.child(node, -1));
      assertSame(child1, operations.child(node, 0));
      assertSame(child2, operations.child(node, 1));
      assertNull(operations.child(node, 2));
      
      verify(operationsHelper);
   }
   
   /**
    * Testa o método {@link OperationsImpl#containsChild(Node, String)}.
    */
   @Test
   public void testContainsChild() {
      Node child1 = createNiceMock(Node.class);
      Node child2 = createNiceMock(Node.class);
      Node child3 = createNiceMock(Node.class);
    
      Node node = createNiceMock(Node.class);
      
      List<Node> children = Arrays.asList(child1, child2, child3);
      
      OperationsHelper operationsHelper = createMock(OperationsHelper.class);
      expect(operationsHelper.children(node)).andReturn(children).times(4);
      expect(operationsHelper.nodeWithName(children, "child1")).andReturn(child1);
      expect(operationsHelper.nodeWithName(children, "child2")).andReturn(child2);
      expect(operationsHelper.nodeWithName(children, "child3")).andReturn(child3);
      expect(operationsHelper.nodeWithName(children, "child4")).andReturn(null);
      replay(operationsHelper);
      
      OperationsImpl operations = new OperationsImpl(operationsHelper);
      
      assertTrue(operations.containsChild(node, "child1"));
      assertTrue(operations.containsChild(node, "child2"));
      assertTrue(operations.containsChild(node, "child3"));
      assertFalse(operations.containsChild(node, "child4"));
      
      verify(operationsHelper);
   }
   
   /**
    * Testa o método {@link OperationsImpl#containsValue(Node)}.
    */
   @Test
   public void testContainsValue() {
      Node node = createStrictMock(Node.class);
      expect(node.getTextContent()).andReturn("abc");
      expect(node.getTextContent()).andReturn(" \t  \n\n    \n \t   \n");
      replay(node);
      
      Node child = createNiceMock(Node.class);
      
      OperationsHelper operationsHelper = createStrictMock(OperationsHelper.class);
      expect(operationsHelper.children(node)).andReturn(Arrays.asList(child));
      expect(operationsHelper.children(node)).andReturn(Collections.<Node>emptyList()).times(2);
      replay(operationsHelper);
      
      OperationsImpl operations = new OperationsImpl(operationsHelper);
      assertFalse(operations.containsValue(node));
      assertTrue(operations.containsValue(node));
      assertFalse(operations.containsValue(node));
      
      verify(node, operationsHelper);
   }
   
   /**
    * Testa se dispara a exceção {@link ElementNotFoundException} ao chamar o método {@link OperationsImpl#find(Document, String)}.
    */
   @Test(expected = ElementNotFoundException.class)
   public void testFindWithElementNotFoundException() {
      Document document = createNiceMock(Document.class);
      
      OperationsHelper operationsHelper = createStrictMock(OperationsHelper.class);
      expect(operationsHelper.find(document, "path")).andReturn(null);
      replay(operationsHelper);
      
      new OperationsImpl(operationsHelper).find(document, "path");
   }
}
