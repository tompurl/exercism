{ pkgs ? import <nixpkgs> {} }:

pkgs.mkShell {
  buildInputs = [
    pkgs.hello
    pkgs.bats

    # keep this line if you use bash
    pkgs.bashInteractive
  ];
}
