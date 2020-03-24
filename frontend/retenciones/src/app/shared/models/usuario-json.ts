export class UsuarioJson {
    idusuario: string= localStorage.getItem("usuario");
    nombre: string= localStorage.getItem("nombre");
    perfil: string= localStorage.getItem("prefil");
    area: string= localStorage.getItem("area");
    cargo:  string= localStorage.getItem("cargo");
    sistema: string= localStorage.getItem("sistema");
}
