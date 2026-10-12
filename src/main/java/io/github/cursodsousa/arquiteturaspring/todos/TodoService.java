package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoRepository repository;
    private TodoValidator validator;
    private MailSender mailSender;

    public TodoService(
            TodoRepository todoRepository,
            TodoValidator todoValidator,
            MailSender mailSender
    ) {
        this.repository = todoRepository;
        this.validator = todoValidator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity novoTodo) {
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }

    public void atualizarStatus(TodoEntity todo) {
        String status = todo.getConcluido() == Boolean.TRUE ? "concluido" : "não concluido";
        mailSender.enviar("Todo " + todo.getDescricao() + " foi atualizado para " + status);
    }

    public TodoEntity buscarPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
