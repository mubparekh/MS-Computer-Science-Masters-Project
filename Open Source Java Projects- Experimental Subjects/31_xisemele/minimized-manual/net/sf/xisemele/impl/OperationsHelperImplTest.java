package net.sf.xisemele.impl;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Casos de teste para a classe {@link OperationsHelperImpl}.
 * 
 * @author Carlos Eduardo Coral.
 */
public class OperationsHelperImplTest {
   
   /**
    * Cria um <i>mock</i> de <code>org.w3c.dom.Node</code> para o nome e filhos especificados por parâmetro.
    * 
    * @param name
    *       <code>java.lang.String</code> que será atribuído ao <i>mock</i> de <code>org.w3c.dom.Node</code>.
    *       
    * @param children
    *       <i>array</i> de <code>org.w3c.dom.Node</code> correspondente aos filhos do <i>mock</i>.
    *       
    * @return
    *       <i>mock</i> de <code>org.w3c.dom.Node</code>.
    */
   private Node createNodeMock(String name, Node... children) {
      NodeList nodeList = createMock(NodeList.class);
      expect(nodeList.getLength()).andReturn(children.length).anyTimes();
      for (int index = 0; index < children.length; index++) {
         expect(nodeList.item(index)).andReturn(children[index]).anyTimes();
      }
      replay(nodeList);
      
      Node node = createMock(Node.class);
      expect(node.getNodeName()).andReturn(name).anyTimes();
      expect(node.getChildNodes()).andReturn(nodeList).anyTimes();
      replay(node);
      
      return node;
   }
   
   /**
    * Cria um <i>mock</i> de <code>org.w3c.dom.Element</code> para o nome e filhos especificados por parâmetro.
    * 
    * @param name
    *       <code>java.lang.String</code> que será atribuído ao <i>mock</i> de <code>org.w3c.dom.Element</code>.
    *       
    * @param children
    *       <i>array</i> de <code>org.w3c.dom.Node</code> correspondente aos filhos do <i>mock</i>.
    *       
    * @return
    *       <i>mock</i> de <code>org.w3c.dom.Element</code>.
    */
   private Element createElementMock(String name, Node... children) {
      NodeList nodeList = createMock(NodeList.class);
      expect(nodeList.getLength()).andReturn(children.length).anyTimes();
      for (int index = 0; index < children.length; index++) {
         expect(nodeList.item(index)).andReturn(children[index]).anyTimes();
      }
      replay(nodeList);
      
      Element element = createMock(Element.class);
      expect(element.getNodeName()).andReturn(name).anyTimes();
      expect(element.getChildNodes()).andReturn(nodeList).anyTimes();
      replay(element);
      
      return element;
   }
   
   /**
    * Testa o método {@link OperationsHelperImpl#nodeWithName(List, String)}.
    */
   @Test
   public void testNodeWithName() {
      Node node0 = createMock(Node.class);
      expect(node0.getNodeName()).andReturn("node0").anyTimes();
      replay(node0);
      
      Node node1 = createMock(Node.class);
      expect(node1.getNodeName()).andReturn("node1").anyTimes();
      replay(node1);
      
      Node node2 = createMock(Node.class);
      expect(node2.getNodeName()).andReturn("node2").anyTimes();
      replay(node2);
      
      List<Node> nodes = Arrays.asList(node0, node1, node2);
      
      OperationsHelperImpl operationsHelper = new OperationsHelperImpl();
      assertSame(node0, operationsHelper.nodeWithName(nodes, "node0"));
      assertSame(node1, operationsHelper.nodeWithName(nodes, "node1"));
      assertSame(node2, operationsHelper.nodeWithName(nodes, "node2"));
      assertNull(operationsHelper.nodeWithName(nodes, "node3"));
      
      verify(node0, node1, node2);
   }
}
