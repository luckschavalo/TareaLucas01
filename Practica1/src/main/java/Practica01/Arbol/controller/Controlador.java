package Practica01.Arbol.controller;

public class Controlador {   
 
    @Controller
    @RequestMapping("/trees")
    class TreeController {

        @Autowired
        private TreeService treeService;

        @GetMapping
        public String getAllTrees(Model model) {
            model.addAttribute("trees", treeService.getAllTrees());
            return "trees/list";
        }

        @GetMapping("/create")
        public String createTreeForm(Model model) {
            model.addAttribute("tree", new Tree());
            return "trees/form";
        }

        @PostMapping
        public String createTree(@ModelAttribute Tree tree) {
            treeService.saveTree(tree);
            return "redirect:/trees";
        }

        @GetMapping("/edit/{id}")
        public String editTreeForm(@PathVariable Long id, Model model) {
            Tree tree = treeService.getAllTrees().stream()
                    .filter(t -> t.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Árbol no encontrado"));
            model.addAttribute("tree", tree);
            return "trees/form";
        }

        @PostMapping("/update/{id}")
        public String updateTree(@PathVariable Long id, @ModelAttribute Tree treeDetails) {
            Tree tree = treeService.getAllTrees().stream()
                    .filter(t -> t.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Árbol no encontrado"));
            tree.setName(treeDetails.getName());
            tree.setSpecies(treeDetails.getSpecies());
            tree.setImageUrl(treeDetails.getImageUrl());
            treeService.saveTree(tree);
            return "redirect:/trees";
        }

        @GetMapping("/delete/{id}")
        public String deleteTree(@PathVariable Long id) {
            treeService.deleteTree(id);
            return "redirect:/trees";
        }
    }
}
