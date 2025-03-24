# Login Page - Angular + Spring Boot + Spring Security

Este projeto foi desenvolvido para implementar uma página de login simples utilizando **Angular** no frontend e **Spring Boot** com **Spring Security** no backend. O objetivo foi colocar em prática os conhecimentos adquiridos em Angular, TypeScript, Java e Spring Boot, criando um sistema de autenticação básico.

## Tecnologias Utilizadas

### Frontend
- **Angular 17**
- **TypeScript**
- **Reactive Forms** (para validação de formulários)
- **ngx-toastr** (para exibir mensagens de sucesso e erro)
- **RxJS** (para programação reativa)
- **Angular Router** (para navegação entre páginas)

### Backend
- **Spring Boot 3**
- **Spring Security** (para autenticação e autorização)
- **JWT** (JSON Web Tokens para autenticação stateless)
- **Spring Data JPA** (para persistência de dados)
- **H2 Database** (banco de dados em memória para desenvolvimento)
- **Lombok** (para reduzir boilerplate code)

## 🚀 Funcionalidades

### Sistema de Autenticação
- Cadastro de novos usuários
- Login com email e senha
- Validação de campos no frontend e backend
- Armazenamento seguro do token JWT
- Proteção de rotas no frontend e backend

### Páginas
- **Página de Login** com validação em tempo real
- **Página de Cadastro** com confirmação de senha
- **Página Home** (após autenticação bem-sucedida)

### Extras
- Interceptors para adicionar token às requisições
- Guards para proteger rotas no Angular
- Mensagens de feedback para o usuário


🔒 **Configuração de Segurança**

O backend está configurado com:
- **Spring Security** com autenticação JWT
- **CSRF protection** desabilitado (para simplificar)
- **CORS** configurado para desenvolvimento
- **PasswordEncoder** com BCrypt
- **Rotas protegidas** por roles

📚 **Referências**

**Tutoriais**
- [Spring Security Tutorial](https://www.toptal.com/spring/spring-security-tutorial)
- [Angular JWT Authentication](https://blog.angular-university.io/angular-jwt-authentication/)
- [Spring Boot + Angular CRUD](https://auth0.com/blog/spring-boot-angular-crud/)

**Documentações Oficiais**
- [Angular Documentation](https://angular.io/docs)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Security Reference](https://docs.spring.io/spring-security/site/docs/current/reference/html5/)

**Vídeos**
- [PROJETO FULLSTACK APP DE LOGIN ANGULAR 17 + JAVA SPRING | FRONTEND](https://youtu.be/6qbuuPM_de4)
- [PROJETO FULLSTACK COM LOGIN USANDO SPRING SECURITY + JWT | BACKEND](https://youtu.be/tJCyNV1G0P4)

🤝 **Como Contribuir**
1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/awesome-feature`)
3. Commit suas mudanças (`git commit -m 'Add some awesome feature'`)
4. Push para a branch (`git push origin feature/awesome-feature`)
5. Abra um Pull Request

📝 **Licença**
Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para detalhes.

Desenvolvido com ❤️ por [MoostDev - João Gionda]  
📧 Contato: [moostdev@gmail.com]  
🔗 GitHub: [https://github.com/Moost999]
