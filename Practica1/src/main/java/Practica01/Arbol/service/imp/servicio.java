

package Practica01.Arbol.service.imp;


public class servicio {
    
    @Service
class TreeServiceImpl implements TreeService {
    @Autowired
    private TreeRepository treeRepository;
    
    public List<Tree> getAllTrees() { return treeRepository.findAll(); }
    public Tree saveTree(Tree tree) { return treeRepository.save(tree); }
    public void deleteTree(Long id) { treeRepository.deleteById(id); }
}

}
