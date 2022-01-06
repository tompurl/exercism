{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = [
    pkgs.hello
    pkgs.bats
    pkgs.inotify-tools

    # keep this line if you use bash
    pkgs.bashInteractive
  ];
}
