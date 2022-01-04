{ pkgs ? import <nixpkgs> {} }:

# This file is to simplify execution using the Nix package manager
# (https://github.com/NixOS/nix). If you are not using this package manager then
# you can safely ignore this file :-)
#
# If you *are* using the Nix package manager then this file works best with the
# following dependencies:
#
# - lorri
# - direnv

pkgs.mkShell {
  buildInputs = [
    pkgs.hello
    pkgs.leiningen
    pkgs.clojure

    # keep this line if you use bash
    pkgs.bashInteractive

  ];
  shellHook = ''
    export THIS_IS_COOL=true
  '';
}
